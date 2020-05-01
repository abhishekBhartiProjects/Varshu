package abhu.loves.varshu.common

class Constants {
    companion object{
        val AMAZON_HOMEPAGE = "https://amzn.to/386sFKN"
        val TYPE_TITLE = "Title"
        val TYPE_PRODUCT = "Product"

        //secondaryCategory and Corrosponding sheetId
        val CAT_MOBILE = "Mobile"
        val SHEETID_MOBILE = "1JmQXTvQ2966mIj_ii9klWkm2miblCF3H0fGMZcsKsec"

        //map
        var scMap: HashMap<String, String> = hashMapOf()
        fun createSecondaryCategoryMap(){
            scMap.clear()
            scMap.put(CAT_MOBILE, SHEETID_MOBILE)
        }

        fun getSecondaryCategoryMap(): HashMap<String, String>{
            return scMap
        }

    }
}