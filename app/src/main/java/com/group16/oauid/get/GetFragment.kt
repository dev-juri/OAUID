package com.group16.oauid.get

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.group16.oauid.BaseFragment
import com.group16.oauid.MainActivity
import com.group16.oauid.R
import com.group16.oauid.createAndDownloadPdf
import com.group16.oauid.databinding.FragmentGetBinding
import com.group16.oauid.viewBinding

class GetFragment : BaseFragment() {

    private val binding by viewBinding(FragmentGetBinding::bind)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_get, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return

        binding.backBtn.setOnClickListener {
            findNavController().navigateUp()
        }

        MainActivity.loggedIn.apply {
            binding.department.text =
                resources.getString(R.string.dept_faculty, this.department, this.faculty)
            binding.fullName.text =
                resources.getString(R.string.id_card_name_matric, this.name, this.matricNum)
            binding.sex.text = this.sex
            binding.passport.setImageResource(this.image)
            this.numberIdGenerated = 1
        }

        binding.print.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Download in progress.",
                Toast.LENGTH_SHORT
            ).show()

            val fileName = "${MainActivity.loggedIn.name}_ID_CARD.pdf"

            with(sharedPref.edit()) {
                putBoolean(MainActivity.loggedIn.matricNum, true)
                apply()
            }

            createAndDownloadPdf(fileName, binding.idLayout)

            Snackbar.make(
                binding.print,
                "$fileName downloaded and stored in the downloads folder.",
                Snackbar.LENGTH_LONG
            )
                /*                    .setAction("Open") {
                                        it.setOnClickListener {
                                            val f = File(
                                                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                                                fileName
                                            )

                                            val intent = Intent()
                                                .setData(f.path.toUri())
                                                .setAction(Intent.CATEGORY_APP_FILES)
                                            startActivity(intent)
                                        }
                                    }*/
                .show()
        }

    }
}
