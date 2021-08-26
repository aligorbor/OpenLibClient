package ru.geekbrains.android2.openlibclient.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import ru.geekbrains.android2.openlibclient.R
import ru.geekbrains.android2.openlibclient.presentation.abs.AbsActivity
import javax.inject.Inject

class MainActivity : AbsActivity() {
    private val navigator = AppNavigator(this, android.R.id.content)

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
     //   savedInstanceState ?: router.newRootScreen(BooksScreen)
    }
}