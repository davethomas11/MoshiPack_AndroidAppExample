package com.daveanthonythomas.moshipack.exampleapp

import android.arch.persistence.room.Room
import com.daveanthonythomas.moshipack.BuildConfig
import com.daveanthonythomas.moshipack.MoshiPack
import com.daveanthonythomas.moshipack.MoshiPackConverterFactory
import com.daveanthonythomas.moshipack.exampleapp.cats.CatEndpoint
import com.daveanthonythomas.moshipack.exampleapp.cats.CatLoader
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

/**
 * Created by dave on 2018-02-25.
 */

object AppModule {

    val module: Module = applicationContext {
        provide {
            Retrofit.Builder()
                    .addConverterFactory(MoshiPackConverterFactory())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(BuildConfig.SERVER_URL)
                    .build()
        }

        provide {
            (get() as Retrofit).create(CatEndpoint::class.java)
        }

        provide {
            Room.databaseBuilder(get(), AppDatabase::class.java,
                    "moshipack-example-app").build()
        }

        provide {
            CatLoader(get(), get())
        }

        provide {
            (get() as AppDatabase).getCatDao()
        }
    }
}
