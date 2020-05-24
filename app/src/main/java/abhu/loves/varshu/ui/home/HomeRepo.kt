package abhu.loves.varshu.ui.home

import abhu.loves.varshu.base.BaseRepo
import abhu.loves.varshu.ui.home.data.model.Entry
import abhu.loves.varshu.ui.home.data.model.HomeData
import abhu.loves.varshu.ui.home.data.model.customModel.*
import io.reactivex.Observable
import io.reactivex.Single

class HomeRepo : BaseRepo() {
    val service = retrofit.create(HomeService::class.java)

    fun getData(): Single<ArrayList<Any>> {
        return service.getWishCardData().map {
            organise(it)
        }
    }

    private fun organise(homeData: HomeData): ArrayList<Any> {

        val organisedGroup: HashMap<String, ArrayList<Entry>> = hashMapOf()
        for (entry in homeData.feed.entry){
            entry.groupId.value?.let {
                if(organisedGroup.containsKey(entry.groupId.value!!)){
                    val entryList = organisedGroup.get(entry.groupId.value!!)
                    entryList!!.add(entry)
                    organisedGroup.put(entry.groupId.value!!, entryList)
                } else {
                    val entryList: ArrayList<Entry> = arrayListOf()
                    entryList.add(entry)
                    organisedGroup.put(entry.groupId.value!!, entryList)
                }
            }
        }

        val organisedData: ArrayList<Any> = arrayListOf()
        if(organisedGroup.containsKey("1_wishCard")){
            val wishCardsList = organisedGroup["1_wishCard"]
            organisedData.add(getWishesCardData(wishCardsList!!))
        }

        if(organisedGroup.containsKey("2_Header")){
            val headerData = organisedGroup["2_Header"]
            organisedData.add(headerData?.get(0)?.text?.value ?: "")
        }

        if(organisedGroup.containsKey("3_myWishes")){
            val myWishCardsList = organisedGroup["3_myWishes"]
            organisedData.addAll(getMyWishesList(myWishCardsList!!))
        }

        if(organisedGroup.containsKey("4_Header")){
            val headerData = organisedGroup["4_Header"]
            organisedData.add(headerData?.get(0)?.text?.value ?: "")
        }

        if(organisedGroup.containsKey("5_friendsWishes")){
            val friendsWishCardsList = organisedGroup["5_friendsWishes"]
            organisedData.addAll(getFriendsWishesList(friendsWishCardsList!!))
        }

        if(organisedGroup.containsKey("6_Header")){
            val headerData = organisedGroup["6_Header"]
            organisedData.add(headerData?.get(0)?.text?.value ?: "")
        }

        if(organisedGroup.containsKey("7_Together")){
            val togetherPicsList = organisedGroup["7_Together"]
            organisedData.add(getTogetherPicsData(togetherPicsList!!))
        }

        if(organisedGroup.containsKey("8_Header")){
            val headerData = organisedGroup["8_Header"]
            organisedData.add(headerData?.get(0)?.text?.value ?: "")
        }

        if(organisedGroup.containsKey("9_Video")){
            val videoEntity = organisedGroup["9_Video"]
            organisedData.add(getMomentsVideo(videoEntity!!))
        }

        if(organisedGroup.containsKey("10_Header")){
            val headerData = organisedGroup["10_Header"]
            organisedData.add(headerData?.get(0)?.text?.value ?: "")
        }

        if(organisedGroup.containsKey("11_collage")){
            val collageList = organisedGroup["11_collage"]
            organisedData.add(getLoveCollage(collageList!!))
        }

        if(organisedGroup.containsKey("12_Header")){
            val headerData = organisedGroup["12_Header"]
            organisedData.add(headerData?.get(0)?.text?.value ?: "")
        }

        if(organisedGroup.containsKey("13_loveMsg")){
            val loveMsg = organisedGroup["13_loveMsg"]
            organisedData.add(getLoveMessage(loveMsg!!))
        }

        if(organisedGroup.containsKey("14_footer")){
            val footerMsg = organisedGroup["14_footer"]
            organisedData.add(getFooterText(footerMsg!!))
        }

        return organisedData
    }

    private fun getWishesCardData(list: ArrayList<Entry>): WishesCardData {
        val cardList = arrayListOf<Card>()
        for(entry in list){
            val text = entry.text.value
            val imageUrl = entry.image.value
            cardList.add(Card(imageUrl!!, text!!))
        }
        val wishesCardData = WishesCardData(cardList)
        return wishesCardData
    }

    private fun getMyWishesList(entryList: ArrayList<Entry>): ArrayList<MyWishCardData> {
        val list = arrayListOf<MyWishCardData>()
        for (entry in entryList){
            list.add(MyWishCardData(entry.text.value!!, entry.image.value!!))
        }
        return list
    }

    private fun getFriendsWishesList(entryList: ArrayList<Entry>): ArrayList<FriendsWishCardData> {
        val list = arrayListOf<FriendsWishCardData>()
        for (entry in entryList){
            list.add(FriendsWishCardData(entry.text.value!!, entry.image.value!!))
        }
        return list
    }

    private fun getTogetherPicsData(entryList: ArrayList<Entry>): TogetherPicsData {
        val picsList = arrayListOf<String>()
        for (entry in entryList){
            picsList.add(entry.image.value!!)
        }
        return TogetherPicsData(picsList)
    }

    private fun getMomentsVideo(videoEntity: ArrayList<Entry>): MomentsVideo {
        val name = videoEntity[0].text.value
        val videoId = videoEntity[0].image.value
        val url = "https://www.youtube.com/watch?v=$videoId"
        val thumbnail = "https://img.youtube.com/vi/$videoId/mqdefault.jpg"
        return MomentsVideo(videoId!!, url, name!!, thumbnail)
    }

    private fun getLoveCollage(list: ArrayList<Entry>): CollageData {
        val collageList = arrayListOf<String>()
        for(entry in list){
            val imageUrl = entry.image.value
            collageList.add(imageUrl!!)
        }
        return CollageData(collageList)
    }

    private fun getLoveMessage(entryList: ArrayList<Entry>): LoveMessage {
        return LoveMessage(entryList[0].text.value!!)
    }

    private fun getFooterText(entryList: ArrayList<Entry>): FooterMessage {
        return FooterMessage(entryList[0].text.value!!)
    }

}