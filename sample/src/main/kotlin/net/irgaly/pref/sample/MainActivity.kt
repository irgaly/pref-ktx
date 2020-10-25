package net.irgaly.pref.sample

import android.os.Bundle
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.adapters.TextViewBindingAdapter
import net.irgaly.pref.sample.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity(R.layout.activity_main) {
    private val store by lazy { PreferencesStore(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =
            ActivityMainBinding.bind(findViewById<ViewGroup>(android.R.id.content).getChildAt(0))
        binding.checked = store.checkValue
        binding.checkedChanged = CompoundButton.OnCheckedChangeListener { _, value ->
            store.checkValue = value
        }
        binding.text = store.textValue
        binding.textChanged = TextViewBindingAdapter.OnTextChanged { value, _, _, _ ->
            store.textValue = value.toString()
        }
    }
}
