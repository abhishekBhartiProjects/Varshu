package abhu.loves.varshu.ui.explore

import abhu.loves.varshu.base.BaseRepo
import abhu.loves.varshu.ui.home.HomeService
import abhu.loves.varshu.ui.home.data.model.HomeData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class ExploreRepo: BaseRepo() {
    val service = retrofit.create(HomeService::class.java)

    suspend fun getExploreData(sheetId: String): HomeData {
        return withContext(Dispatchers.IO){
            val response = async{ service.getExploreData(sheetId)}

            return@withContext response.await()
        }
    }

}