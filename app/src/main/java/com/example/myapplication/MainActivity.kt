package com.example.myapplication
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private var currentLanguageIndex = 0
    private val supportedLanguages = arrayOf("es", "en", "de", "fr")
    private lateinit var welcomeButton: Button
    private lateinit var welcomeMessageTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcomeButton = findViewById(R.id.welcomeButton)
        welcomeMessageTextView = findViewById(R.id.welcomeMessageTextView)

        welcomeButton.setOnClickListener {
            changeLanguage()
        }

        // Establecer el idioma predeterminado al iniciar la actividad
        setLocale("es")
        updateTexts()
    }

    private fun changeLanguage() {
        currentLanguageIndex = (currentLanguageIndex + 1) % supportedLanguages.size
        val languageCode = supportedLanguages[currentLanguageIndex]
        setLocale(languageCode)
        updateTexts()
    }

    private fun setLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val resources: Resources = resources
        val configuration: Configuration = resources.configuration
        val displayMetrics: DisplayMetrics = resources.displayMetrics

        configuration.setLocale(locale)
        resources.updateConfiguration(configuration, displayMetrics)
    }

    private fun updateTexts() {
        val buttonTextId = when (currentLanguageIndex) {
            0 -> R.string.button_text
            1 -> R.string.button_text
            2 -> R.string.button_text
            3 -> R.string.button_text
            else -> R.string.button_text
        }
        welcomeButton.setText(buttonTextId)

        val welcomeMessageId = when (currentLanguageIndex) {
            0 -> R.string.welcome_message
            1 -> R.string.welcome_message
            2 -> R.string.welcome_message
            3 -> R.string.welcome_message
            else -> R.string.welcome_message
        }
        welcomeMessageTextView.setText(welcomeMessageId)
    }
}