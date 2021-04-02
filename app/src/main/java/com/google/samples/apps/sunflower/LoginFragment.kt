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

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.google.samples.apps.sunflower.databinding.FragmentLoginBinding
import com.talobin.robinhood.RHSDK
import com.talobin.robinhood.api.NetworkClient
import com.talobin.robinhood.util.RandomQueryGenerator
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.schedulers.Schedulers


@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding


    private val sdk = RHSDK
    private val networkClient = sdk.getNetworkClient()

    //Example of dependency injection
/*    @Inject
    lateinit var service: RobinhoodService*/


    @RequiresApi(Build.VERSION_CODES.O)
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
            // networkClient.getPhoenixAccount()


        }

        binding.testButton.setOnClickListener {
            // networkClient.removeSymbolFromList("d3702af7-60ba-418c-982f-51e2a931f74a","e39ed23a-7bd1-4587-b060-71988d9ef483")
            // 4b91da2c-2878-4c82-80ec-d6a0d2cb4a28
            //e39ed23a-7bd1-4587-b060-71988d9ef483
            //  networkClient.getPriceBookByID("e39ed23a-7bd1-4587-b060-71988d9ef483")
            /*   networkClient.searchProper("A")?.map { result ->
                   Log.d("HAI", "Search result for A" + result?.get(0)?.symbol)
               }?.subscribe()
   */
            //executeAllSearches(queryGenerator.getNextQuery())
            //val allSymbols =  Files.readAllLines( Paths.get("symbols.json"))
           // Log.d("HAI", "All symbols" +allSymbols)

            //val symbols = sdk.getAllSymbolsFromCache(context)
            sdk.getAllSymbolsFromAPI().subscribe{
                Log.d("HAI", "Each symbol $it")
            }
        }

        networkClient.init(requireContext())

        return binding.root
    }


}
