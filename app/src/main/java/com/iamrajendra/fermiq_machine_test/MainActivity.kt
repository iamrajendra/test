package com.iamrajendra.fermiq_machine_test

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.iamrajendra.fermiq_machine_test.adapter.CountryAdapter
import com.iamrajendra.fermiq_machine_test.utlis.JsonParserFromAsset
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
  lateinit   var jsonParser :JsonParserFromAsset

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(getResources().getBoolean(R.bool.portrait_only)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        jsonParser = JsonParserFromAsset()
        list.layoutManager = LinearLayoutManager(applicationContext)
        val dividerItemDecoration = DividerItemDecoration(
            list.getContext(),
            (list.layoutManager as LinearLayoutManager).getOrientation()
        )
        list.addItemDecoration(dividerItemDecoration)
        var countryAdapter = CountryAdapter(jsonParser.loadJSONFromAssets(applicationContext))

        countryAdapter.setOnClickRow {

            Log.i(TAG,"Res"+it.name)
            Glide.with(applicationContext).load(it.getImage())
                .placeholder(R.drawable.ic_image_black_24dp)
                .error(R.drawable.ic_image_red_24dp)                .into(imageView)

        }
        list.adapter = countryAdapter

//        Log.i(TAG,"Res"+jsonParser.loadJSONFromAssets(applicationContext))
    }

    companion object{

        val TAG:String = MainActivity::class.java.simpleName
    }


}
