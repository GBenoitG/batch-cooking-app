package fr.bendev.batchcookingapp.framework

import fr.bendev.batchcookingapp.data.datasources.local.CookbookLocalDatasource
import fr.bendev.batchcookingapp.framework.datasource.local.CookbookLocalDatasourceImpl
import fr.bendev.batchcookingapp.framework.mappers.fromDomainToDB
import fr.bendev.batchcookingapp.framework.utils.FakeCookbookDao
import fr.bendev.batchcookingapp.framework.utils.FakeCookbookEntry
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CookbookLocalDatasourceTest {

    private lateinit var instanceDatasource: CookbookLocalDatasource

    private lateinit var fakeCookbookDao: FakeCookbookDao

    @Before
    fun setupDatasource() {
        fakeCookbookDao = FakeCookbookDao()
        instanceDatasource = CookbookLocalDatasourceImpl(fakeCookbookDao)
    }

    @Test
    fun `GIVEN a list of 2 entry DB, WHEN get all entries, THEN get a list of 2 entry`() =
        runTest(UnconfinedTestDispatcher()) {
            // GIVEN
            fakeCookbookDao.cookbookTable.value = FakeCookbookEntry.entries.fromDomainToDB()

            // WHEN
            val entriesFlow = instanceDatasource.getAllEntries()

            // THEN
            assertEquals(FakeCookbookEntry.entries, entriesFlow.first())
        }

    @Test
    fun `GIVEN nothing saved, WHEN get all entries, THEN get an empty list`() =
        runTest(UnconfinedTestDispatcher()) {
            // GIVEN
            fakeCookbookDao.cookbookTable.value = emptyList()

            // WHEN
            val entriesFlow = instanceDatasource.getAllEntries()

            // THEN
            assertTrue(entriesFlow.first().isEmpty())
        }

    @Test
    fun `GIVEN nothing saved, WHEN save 2 entries, THEN 2 entries are saved`() =
        runTest(UnconfinedTestDispatcher()) {
            // GIVEN
            fakeCookbookDao.cookbookTable.value = emptyList()

            // WHEN
            instanceDatasource.saveAllEntries(FakeCookbookEntry.entries)

            // THEN
            assertTrue(fakeCookbookDao.cookbookTable.value.isNotEmpty())
            assertEquals(fakeCookbookDao.cookbookTable.value.size, 2)
        }

    @Test
    fun `GIVEN nothing saved, WHEN save empty list, THEN still nothing saved`() =
        runTest(UnconfinedTestDispatcher()) {
            // GIVEN
            fakeCookbookDao.cookbookTable.value = emptyList()

            // WHEN
            instanceDatasource.saveAllEntries(emptyList())

            // THEN
            assertTrue(fakeCookbookDao.cookbookTable.value.isEmpty())
            assertEquals(fakeCookbookDao.cookbookTable.value.size, 0)
        }

}