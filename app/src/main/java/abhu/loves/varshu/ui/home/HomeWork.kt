package abhu.loves.varshu.ui.home

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class HomeWork(val context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        val inputData = inputData
        Log.e("Worker InputData: ", inputData.getString("inputData"))

        val output = Data.Builder()
            .putString("outputData" , "This is output data")
            .build()


        return Result.success(output)
    }
}