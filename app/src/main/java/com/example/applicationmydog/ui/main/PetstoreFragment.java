package com.example.applicationmydog.ui.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.applicationmydog.R;
import com.example.applicationmydog.databinding.PetstoreFragmentBinding;
import com.squareup.picasso.Picasso;


public class PetstoreFragment extends Fragment {

    private PetstoreFragmentBinding binding;

    public static PetstoreFragment newInstance() {

        return new PetstoreFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     binding = PetstoreFragmentBinding.inflate(inflater, container,false);
     return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Loading images to the products of petstore fragment

        //Product one
        Picasso.get().load("https://m.media-amazon.com/images/I/610Cn6XhihL._AC_UL480_FMwebp_QL65_.jpg")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(binding.storeProductOne);

        //Redirecting the click event to amazon product
        binding.storeBtnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amazonProductUrl = "https://www.amazon.com.au/Grinder-Electric-Rechargeable-Charging-Trimmer/dp/B07BPTSBTB/ref=sr_1_3_sspa?dib=eyJ2IjoiMSJ9.vQJMA9-z5wSEext0PF2vbYJzmz9KEFlaJRGAZ1I2KY51MF31aniRwqWo3R1EV0BoNkK4EHnxNvzxrrS8RqCIxAZg_JLax_lyMR_2zCsM5WqR161-zs5PlcIINWvoCPXpIGGDB27fQqcRq56J8vuaxj2fsnQG89ocdy-bn1BzD2wsVzrwl1QpmtkqNjMVK_KPkT9qSLpGSOTGWzyToJ_xrkum2hzHccuWuAA7QWUH50iVGYkLM3pXlPrmeL8-lLgNFUCiXR8ZaNMnh5bIT7RhN6NrFLIU7kkcUZf72loT9AY.MBf3L0ghgaMWJVJFkfS34WonbOuSUKca8jD3XYVwYRA&dib_tag=se&keywords=dog+products&qid=1713057451&sr=8-3-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1";
                Uri uri = Uri.parse(amazonProductUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //Product two
        Picasso.get().load("https://m.media-amazon.com/images/I/71zl59tnvyL._AC_SY300_SX300_.jpg")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(binding.storeProductTwo);

        //Redirecting the click event to amazon product
        binding.storeBtnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amazonProductUrl = "https://www.amazon.com.au/FLEXECHO-Professional-Detachable-Rechargeable-Pet%EF%BC%86Quiet/dp/B09MCWYPPW/ref=sr_1_29?crid=3NDK7F3HG1SL9&dib=eyJ2IjoiMSJ9.vQJMA9-z5wSEext0PF2vbYJzmz9KEFlaJRGAZ1I2KY51MF31aniRwqWo3R1EV0BoNkK4EHnxNvzxrrS8RqCIxAZg_JLax_lyMR_2zCsM5WqR161-zs5PlcIINWvoCPXp4vozsinsUk4A4UA2j7vRVna1PHHu41j7EllA4F90CByPdmSF6Q5hK_v1TQxFittikT9qSLpGSOTGWzyToJ_xrrAdKHtV03WEGSflXtMeBgDLZoU2lm9Edcn5Opui-ytZYOCNViy6nshO3NrFJqmn2HF0B_NtnbJgjljlAmMrdpg.h-gLSYFCaJujnHEXUnohd5uED8z9P-nv3HS5J-mMxGE&dib_tag=se&keywords=dog%2Bproducts&qid=1713047201&sprefix=dog%2Bproducts%2Caps%2C299&sr=8-29&th=1";
                Uri uri = Uri.parse(amazonProductUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //Product three
        Picasso.get().load("https://m.media-amazon.com/images/I/81ulRQkt+7L._AC_SX679_.jpg")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(binding.storeProductThree);

        //Redirecting the click event to amazon product
        binding.storeBtnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amazonProductUrl = "https://www.amazon.com.au/All-Absorb-Male-Dog-Wrap-Count/dp/B07C22NTL4/ref=sr_1_13?crid=3NDK7F3HG1SL9&dib=eyJ2IjoiMSJ9.vQJMA9-z5wSEext0PF2vbYJzmz9KEFlaJRGAZ1I2KY51MF31aniRwqWo3R1EV0BoNkK4EHnxNvzxrrS8RqCIxAZg_JLax_lyMR_2zCsM5WqR161-zs5PlcIINWvoCPXp4vozsinsUk4A4UA2j7vRVna1PHHu41j7EllA4F90CByPdmSF6Q5hK_v1TQxFittikT9qSLpGSOTGWzyToJ_xrrAdKHtV03WEGSflXtMeBgDLZoU2lm9Edcn5Opui-ytZYOCNViy6nshO3NrFJqmn2HF0B_NtnbJgjljlAmMrdpg.h-gLSYFCaJujnHEXUnohd5uED8z9P-nv3HS5J-mMxGE&dib_tag=se&keywords=dog%2Bproducts&qid=1713047201&sprefix=dog%2Bproducts%2Caps%2C299&sr=8-13&th=1";
                Uri uri = Uri.parse(amazonProductUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //Product four
        Picasso.get().load("https://m.media-amazon.com/images/I/81e4v77delL._AC_SX679_.jpg")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(binding.storeProductFour);

        //Redirecting the click event to amazon product
        binding.storeBtnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amazonProductUrl = "https://www.amazon.com.au/Advocate-Heartworm-Treatment-10-25-Large/dp/B00JAUQR1M/ref=sr_1_9?crid=3NDK7F3HG1SL9&dib=eyJ2IjoiMSJ9.vQJMA9-z5wSEext0PF2vbYJzmz9KEFlaJRGAZ1I2KY51MF31aniRwqWo3R1EV0BoNkK4EHnxNvzxrrS8RqCIxAZg_JLax_lyMR_2zCsM5WqR161-zs5PlcIINWvoCPXp4vozsinsUk4A4UA2j7vRVna1PHHu41j7EllA4F90CByPdmSF6Q5hK_v1TQxFittikT9qSLpGSOTGWzyToJ_xrrAdKHtV03WEGSflXtMeBgDLZoU2lm9Edcn5Opui-ytZYOCNViy6nshO3NrFJqmn2HF0B_NtnbJgjljlAmMrdpg.h-gLSYFCaJujnHEXUnohd5uED8z9P-nv3HS5J-mMxGE&dib_tag=se&keywords=dog%2Bproducts&qid=1713047201&sprefix=dog%2Bproducts%2Caps%2C299&sr=8-9&th=1";
                Uri uri = Uri.parse(amazonProductUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //Product five
        Picasso.get().load("https://m.media-amazon.com/images/I/71PI0Dxyx2L._AC_SX679_.jpg")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(binding.storeProductFive);

        //Redirecting the click event to amazon product
        binding.storeBtnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amazonProductUrl = "https://www.amazon.com.au/Vets-Best-Complete-Enzymatic-Toothbrush/dp/B06XKJNFXX/ref=sr_1_19?crid=3NDK7F3HG1SL9&dib=eyJ2IjoiMSJ9.vQJMA9-z5wSEext0PF2vbYJzmz9KEFlaJRGAZ1I2KY51MF31aniRwqWo3R1EV0BoNkK4EHnxNvzxrrS8RqCIxAZg_JLax_lyMR_2zCsM5WqR161-zs5PlcIINWvoCPXp4vozsinsUk4A4UA2j7vRVna1PHHu41j7EllA4F90CByPdmSF6Q5hK_v1TQxFittikT9qSLpGSOTGWzyToJ_xrrAdKHtV03WEGSflXtMeBgDLZoU2lm9Edcn5Opui-ytZYOCNViy6nshO3NrFJqmn2HF0B_NtnbJgjljlAmMrdpg.h-gLSYFCaJujnHEXUnohd5uED8z9P-nv3HS5J-mMxGE&dib_tag=se&keywords=dog+products&qid=1713047201&sprefix=dog+products%2Caps%2C299&sr=8-19";
                Uri uri = Uri.parse(amazonProductUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //Product six
        Picasso.get().load("https://m.media-amazon.com/images/I/71OvGWUeZOL._AC_SX679_.jpg")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(binding.storeProductSix);

        //Redirecting the click event to amazon product
        binding.storeBtnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amazonProductUrl = "https://www.amazon.com.au/Friendly-No-Rinse-Waterless-Shampoo-Coconut/dp/B00GZQYLOE/ref=sr_1_27?crid=3NDK7F3HG1SL9&dib=eyJ2IjoiMSJ9.vQJMA9-z5wSEext0PF2vbYJzmz9KEFlaJRGAZ1I2KY51MF31aniRwqWo3R1EV0BoNkK4EHnxNvzxrrS8RqCIxAZg_JLax_lyMR_2zCsM5WqR161-zs5PlcIINWvoCPXp4vozsinsUk4A4UA2j7vRVna1PHHu41j7EllA4F90CByPdmSF6Q5hK_v1TQxFittikT9qSLpGSOTGWzyToJ_xrrAdKHtV03WEGSflXtMeBgDLZoU2lm9Edcn5Opui-ytZYOCNViy6nshO3NrFJqmn2HF0B_NtnbJgjljlAmMrdpg.h-gLSYFCaJujnHEXUnohd5uED8z9P-nv3HS5J-mMxGE&dib_tag=se&keywords=dog%2Bproducts&qid=1713047201&sprefix=dog%2Bproducts%2Caps%2C299&sr=8-27&th=1";
                Uri uri = Uri.parse(amazonProductUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //Product seven
        Picasso.get().load("https://m.media-amazon.com/images/I/71KHlJw+8TL._AC_SY300_SX300_.jpg")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(binding.storeProductSeven);

        //Redirecting the click event to amazon product
        binding.storeBtnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amazonProductUrl = "https://www.amazon.com.au/Toothbrush-Interactive-Squeaky-Aggressive-Chewers/dp/B08NJJQ1KW/ref=sr_1_8?dib=eyJ2IjoiMSJ9.vQJMA9-z5wSEext0PF2vbYJzmz9KEFlaJRGAZ1I2KY51MF31aniRwqWo3R1EV0BoNkK4EHnxNvzxrrS8RqCIxAZg_JLax_lyMR_2zCsM5WqR161-zs5PlcIINWvoCPXpIGGDB27fQqcRq56J8vuaxj2fsnQG89ocdy-bn1BzD2wsVzrwl1QpmtkqNjMVK_KPkT9qSLpGSOTGWzyToJ_xrkum2hzHccuWuAA7QWUH50iVGYkLM3pXlPrmeL8-lLgNFUCiXR8ZaNMnh5bIT7RhN6NrFLIU7kkcUZf72loT9AY.MBf3L0ghgaMWJVJFkfS34WonbOuSUKca8jD3XYVwYRA&dib_tag=se&keywords=dog%2Bproducts&qid=1713057596&sr=8-8&th=1";
                Uri uri = Uri.parse(amazonProductUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //Product eight
        Picasso.get().load("https://m.media-amazon.com/images/I/71jgeANeQKL._AC_SX679_.jpg")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(binding.storeProductEight);

        //Redirecting the click event to amazon product
        binding.storeBtnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amazonProductUrl = "https://www.amazon.com.au/Dispenser-Cleaning-Exercise-Training-Nontoxic/dp/B0CBDVYYYB/ref=sr_1_34?dib=eyJ2IjoiMSJ9.vQJMA9-z5wSEext0PF2vbYJzmz9KEFlaJRGAZ1I2KY51MF31aniRwqWo3R1EV0BoNkK4EHnxNvzxrrS8RqCIxAZg_JLax_lyMR_2zCsM5WqR161-zs5PlcIINWvoCPXpIGGDB27fQqcRq56J8vuaxj2fsnQG89ocdy-bn1BzD2wsVzrwl1QpmtkqNjMVK_KPkT9qSLpGSOTGWzyToJ_xrkum2hzHccuWuAA7QWUH50iVGYkLM3pXlPrmeL8-lLgNFUCiXR8ZaNMnh5bIT7RhN6NrFLIU7kkcUZf72loT9AY.MBf3L0ghgaMWJVJFkfS34WonbOuSUKca8jD3XYVwYRA&dib_tag=se&keywords=dog%2Bproducts&qid=1713057596&sr=8-34&th=1";
                Uri uri = Uri.parse(amazonProductUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        binding.toTheTopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.petStoreScrollView.smoothScrollTo(0, 0);
            }
        });
    }



}