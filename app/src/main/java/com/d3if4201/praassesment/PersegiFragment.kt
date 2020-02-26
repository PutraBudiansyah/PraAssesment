package com.d3if4201.praassesment


import android.content.ActivityNotFoundException
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import com.d3if4201.praassesment.databinding.FragmentPersegiBinding
import kotlinx.android.synthetic.main.fragment_persegi.*

/**
 * A simple [Fragment] subclass.
 */
class PersegiFragment : Fragment() {
    companion object {
        var P = 0
        var L = 0
        var Luas = 0
        var Keliling = 0
        var KeyLuas = "1"
        var KeyKeliling = "2"


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPersegiBinding>(
            inflater,
            R.layout.fragment_persegi,
            container,
            false
        )
        if (savedInstanceState != null) {
            Luas = savedInstanceState.getInt(KeyLuas)
            Keliling = savedInstanceState.getInt(KeyKeliling)
            binding.tvLuasPP.setText(Luas.toString())
            binding.tvKelilingPP.setText(Keliling.toString())
        }
        binding.btnHitungPP.setOnClickListener {
            P = panjangPP.text.toString().toInt()
            L = LebarPP.text.toString().toInt()
            Luas = P * L
            Keliling = 2 * (P + L)
            tvLuasPP.setText(Luas.toString())
            tvKelilingPP.setText(Keliling.toString())


        }
        binding.btnShare.setOnClickListener {
            val shareIntent = ShareCompat.IntentBuilder.from(requireActivity())
                .setType("Text/plaint")
                .setText(getString(R.string.share_PP,P,L,Luas,Keliling))
                .intent
            try {
                startActivity(shareIntent)
            }catch (ex: ActivityNotFoundException){
                Toast.makeText(context,"Not Found",Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(KeyLuas, Luas)
        outState.putInt(KeyKeliling, Keliling)
        super.onSaveInstanceState(outState)
    }
}




