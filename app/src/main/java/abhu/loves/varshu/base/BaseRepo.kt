package abhu.loves.varshu.base

import abhu.loves.varshu.network.RetrofitInstance

open class BaseRepo {
    protected val retrofit = RetrofitInstance.getInstance()
}