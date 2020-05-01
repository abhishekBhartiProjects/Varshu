package abhu.loves.varshu.ui.home

import abhu.loves.varshu.ui.home.model.HomeData
import io.reactivex.Single
import retrofit2.http.*

interface HomeService {

    @GET("feeds/list/16mh9nZ5n3uPsxuY8U0l6cNqJv9QNQvrzvJQ_eIC_SeE/od6/public/values?alt=json")
    fun getHomeData():Single<HomeData>

    @GET("feeds/list/{id}/od6/public/values?alt=json")
    suspend fun getExploreData(
        @Path("id") id: String
    ):HomeData
}