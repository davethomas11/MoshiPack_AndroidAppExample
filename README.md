# MoshiPack_AndroidAppExample

https://github.com/davethomas11/MoshiPack

This is an example implementation of using moshipack-retrofit.
There is a node server at https://fierce-fortress-58676.herokuapp.com/ which is serving up MessagePack.
Sever source code: https://github.com/davethomas11/MoshiPack_TestNodeServer

This app downloads the MessagePack from the endpoint /cats and displays a list of cats.

Using moshipack-retrofit to do this is as simple as:

```
interface CatEndpoint {
    @GET("/cats")
    fun getCats(): Call<List<Cat>>
}

val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiPackConverterFactory())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(BuildConfig.SERVER_URL)
        .build()

val cats = retrofit.create(CatEndPoint::class.java).getCats().execute().body()
```

I am using RXJava so instead of Call in my implementation you will see Observable, but to find the relevant code look in these files:

Retrofit with MoshiPack instantiation:
https://github.com/davethomas11/MoshiPack_AndroidAppExample/blob/master/app/src/main/java/com/daveanthonythomas/moshipack/exampleapp/Module.kt
https://github.com/davethomas11/MoshiPack_AndroidAppExample/blob/master/app/src/main/java/com/daveanthonythomas/moshipack/exampleapp/cats/CatEndpoint.kt

Cat end point call:
https://github.com/davethomas11/MoshiPack_AndroidAppExample/blob/master/app/src/main/java/com/daveanthonythomas/moshipack/exampleapp/cats/CatLoader.kt
