/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.sunflower

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.samples.apps.sunflower.databinding.FragmentLoginBinding
import com.talobin.robinhood.api.NetworkClient
import com.talobin.robinhood.data.account.Direction
import com.talobin.robinhood.data.account.TransactionType
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    private val networkClient = NetworkClient

    //Example of dependency injection
/*    @Inject
    lateinit var service: RobinhoodService*/


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.loginButton.setOnClickListener {

            Log.d("HAI", "pass: " + binding.password)
            Log.d("HAI", "user: " + binding.username)
            networkClient.startLogin(binding.username.toString(), binding.password.toString())
        }

        binding.verifyButton.setOnClickListener {
            Log.d("HAI", "mfa: " + binding.mfa)
            networkClient.verifyMFACode(binding.mfa.toString())
        }

        binding.accountButton.setOnClickListener {
            networkClient.getPhoenixAccount()
        }

        binding.testButton.setOnClickListener {
           // networkClient.removeSymbolFromList("d3702af7-60ba-418c-982f-51e2a931f74a","e39ed23a-7bd1-4587-b060-71988d9ef483")
           // 4b91da2c-2878-4c82-80ec-d6a0d2cb4a28
            //e39ed23a-7bd1-4587-b060-71988d9ef483
          //  networkClient.getPriceBookByID("e39ed23a-7bd1-4587-b060-71988d9ef483")
            networkClient.searchProper("A")?.map { result ->
                Log.d("HAI", "Search result for A" + result?.get(0)?.symbol)
            }?.subscribe()
        }


        networkClient.init(requireContext())

        return binding.root
    }

}