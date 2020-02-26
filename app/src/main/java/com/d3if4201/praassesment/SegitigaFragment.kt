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
import com.d3if4201.praassesment.databinding.FragmentSegitigaBinding
import kotlinx.android.synthetic.main.fragment_persegi.*
import kotlin.math.sqrt

/**
 * A simple [Fragment] subclass.
 */
class SegitigaFragment : Fragment() {
    companion object {
        var A: Double = 0.00
        var T: Double = 0.00
        var pytagoras: Double = 0.00
        var Luas:Double = 0.00
        var Keliling:Double = 0.00
        var KeyAlas = "1"
        var KeyTinggi = "2"


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSegitigaBinding>(inflater,R.layout.fragment_segitiga,container,false)
        if (savedInstanceState!=null){
            Luas = savedInstanceState.getDouble(KeyAlas)
            Keliling = savedInstanceState.getDouble(KeyTinggi)
            binding.panjangPP.setText(Luas.toString())
            binding.LebarPP.setText(Keliling.toString())

        }
        binding.btnHitungPP.setOnClickListener{
            A = panjangPP.text.toString().toDouble()
            T = LebarPP.text.toString().toDouble()
            pytagoras = sqrt(A * A + T * T)
            Luas = A * T/2
            Keliling = A+T + pytagoras
            tvLuasPP.setText(Luas.toString())
            tvKelilingPP.setText(Keliling.toString())

        }
        binding.btnShare.setOnClickListener {
            val shareIntent = ShareCompat.IntentBuilder.from(requireActivity())
                .setType("Text/plaint")
                .setText(getString(R.string.share_PP,
                    PersegiFragment.P,
                    PersegiFragment.L,
                    PersegiFragment.Luas,
                    PersegiFragment.Keliling
                ))
                .intent
            try {
                startActivity(shareIntent)
            }catch (ex: ActivityNotFoundException){
                Toast.makeText(context,"Not Found", Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putDouble(KeyAlas, A)
        outState.putDouble(KeyTinggi, T)
        super.onSaveInstanceState(outState)
    }
    }




