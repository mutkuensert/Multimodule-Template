package multimoduletemplate

import android.app.Application
import com.mutkuensert.multimoduletemplate.BuildConfig
import core.data.network.networkModule
import core.database.databaseModule
import core.injection.feature.movies.moviesModule
import core.ui.uiModule
import multimoduletemplate.ui.home.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import timber.log.Timber

class MultimoduleTemplate : Application() {
    override fun onCreate() {
        super.onCreate()

        plantTimber()
        startKoin {
            androidLogger()
            androidContext(this@MultimoduleTemplate)
            modules(
                homeModule,
                uiModule,
                networkModule,
                databaseModule,
                moviesModule
            )
        }
    }

    private fun plantTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
