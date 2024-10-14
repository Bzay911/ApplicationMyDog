package com.example.applicationmydog.ui.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.applicationmydog.R;
import com.example.applicationmydog.databinding.HomeFragmentBinding;
import com.squareup.picasso.Picasso;


public class HomeFragment extends Fragment {

    private HomeFragmentBinding binding;

    public static HomeFragment newInstance() {

        return new HomeFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = HomeFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Loading image into profile picture
        Picasso.get().load("https://static.vecteezy.com/system/resources/previews/021/244/162/non_2x/cartoon-dog-pet-characters-illustration-png.png")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(binding.dogProfileImageView);

        //Main display image
        Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3H9hHSS3KfDXyAyWNmA0goT4uFWAzP0N2CsrghNBrbg&s")
                .placeholder(R.drawable.placeholder)
                .fit()
                .centerInside()
                .error(R.drawable.placeholder)
                .into(binding.homePageImage);


        //Loading images to the products of homepage
        //Product one
        Picasso.get().load("https://m.media-amazon.com/images/I/610Cn6XhihL._AC_UL480_FMwebp_QL65_.jpg")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(binding.homeProductOne);

        //Redirecting the click event to amazon product
        binding.homeBtnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amazonProductUrl = "https://www.amazon.com.au/Grinder-Electric-Rechargeable-Charging-Trimmer/dp/B07BPTSBTB/ref=sr_1_3_sspa?dib=eyJ2IjoiMSJ9.vQJMA9-z5wSEext0PF2vbYJzmz9KEFlaJRGAZ1I2KY51MF31aniRwqWo3R1EV0BoNkK4EHnxNvzxrrS8RqCIxAZg_JLax_lyMR_2zCsM5WqR161-zs5PlcIINWvoCPXpIGGDB27fQqcRq56J8vuaxj2fsnQG89ocdy-bn1BzD2wsVzrwl1QpmtkqNjMVK_KPkT9qSLpGSOTGWzyToJ_xrkum2hzHccuWuAA7QWUH50iVGYkLM3pXlPrmeL8-lLgNFUCiXR8ZaNMnh5bIT7RhN6NrFLIU7kkcUZf72loT9AY.MBf3L0ghgaMWJVJFkfS34WonbOuSUKca8jD3XYVwYRA&dib_tag=se&keywords=dog+products&qid=1713057451&sr=8-3-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1";
                Uri uri = Uri.parse(amazonProductUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //Product two
        Picasso.get().load("https://m.media-amazon.com/images/I/81ulRQkt+7L._AC_SX679_.jpg")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(binding.homeProductTwo);

        //Redirecting the click event to amazon product
        binding.homeBtnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amazonProductUrl = "https://www.amazon.com.au/All-Absorb-Male-Dog-Wrap-Count/dp/B07C22NTL4/ref=sr_1_13?crid=3NDK7F3HG1SL9&dib=eyJ2IjoiMSJ9.vQJMA9-z5wSEext0PF2vbYJzmz9KEFlaJRGAZ1I2KY51MF31aniRwqWo3R1EV0BoNkK4EHnxNvzxrrS8RqCIxAZg_JLax_lyMR_2zCsM5WqR161-zs5PlcIINWvoCPXp4vozsinsUk4A4UA2j7vRVna1PHHu41j7EllA4F90CByPdmSF6Q5hK_v1TQxFittikT9qSLpGSOTGWzyToJ_xrrAdKHtV03WEGSflXtMeBgDLZoU2lm9Edcn5Opui-ytZYOCNViy6nshO3NrFJqmn2HF0B_NtnbJgjljlAmMrdpg.h-gLSYFCaJujnHEXUnohd5uED8z9P-nv3HS5J-mMxGE&dib_tag=se&keywords=dog%2Bproducts&qid=1713047201&sprefix=dog%2Bproducts%2Caps%2C299&sr=8-13&th=1";
                Uri uri = Uri.parse(amazonProductUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //Product three
        Picasso.get().load("https://m.media-amazon.com/images/I/81e4v77delL._AC_SX679_.jpg")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(binding.homeProductThree);

        //Redirecting the click event to amazon product
        binding.homeBtnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amazonProductUrl = "https://www.amazon.com.au/Advocate-Heartworm-Treatment-10-25-Large/dp/B00JAUQR1M/ref=sr_1_9?crid=3NDK7F3HG1SL9&dib=eyJ2IjoiMSJ9.vQJMA9-z5wSEext0PF2vbYJzmz9KEFlaJRGAZ1I2KY51MF31aniRwqWo3R1EV0BoNkK4EHnxNvzxrrS8RqCIxAZg_JLax_lyMR_2zCsM5WqR161-zs5PlcIINWvoCPXp4vozsinsUk4A4UA2j7vRVna1PHHu41j7EllA4F90CByPdmSF6Q5hK_v1TQxFittikT9qSLpGSOTGWzyToJ_xrrAdKHtV03WEGSflXtMeBgDLZoU2lm9Edcn5Opui-ytZYOCNViy6nshO3NrFJqmn2HF0B_NtnbJgjljlAmMrdpg.h-gLSYFCaJujnHEXUnohd5uED8z9P-nv3HS5J-mMxGE&dib_tag=se&keywords=dog%2Bproducts&qid=1713047201&sprefix=dog%2Bproducts%2Caps%2C299&sr=8-9&th=1";
                Uri uri = Uri.parse(amazonProductUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //Product four
        Picasso.get().load("https://m.media-amazon.com/images/I/71PI0Dxyx2L._AC_SX679_.jpg")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(binding.homeProductFour);

        //Redirecting the click event to amazon product
        binding.homeBtnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amazonProductUrl = "https://www.amazon.com.au/Vets-Best-Complete-Enzymatic-Toothbrush/dp/B06XKJNFXX/ref=sr_1_19?crid=3NDK7F3HG1SL9&dib=eyJ2IjoiMSJ9.vQJMA9-z5wSEext0PF2vbYJzmz9KEFlaJRGAZ1I2KY51MF31aniRwqWo3R1EV0BoNkK4EHnxNvzxrrS8RqCIxAZg_JLax_lyMR_2zCsM5WqR161-zs5PlcIINWvoCPXp4vozsinsUk4A4UA2j7vRVna1PHHu41j7EllA4F90CByPdmSF6Q5hK_v1TQxFittikT9qSLpGSOTGWzyToJ_xrrAdKHtV03WEGSflXtMeBgDLZoU2lm9Edcn5Opui-ytZYOCNViy6nshO3NrFJqmn2HF0B_NtnbJgjljlAmMrdpg.h-gLSYFCaJujnHEXUnohd5uED8z9P-nv3HS5J-mMxGE&dib_tag=se&keywords=dog+products&qid=1713047201&sprefix=dog+products%2Caps%2C299&sr=8-19";
                Uri uri = Uri.parse(amazonProductUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //Product Five
        Picasso.get().load("https://m.media-amazon.com/images/I/71OvGWUeZOL._AC_SX679_.jpg")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(binding.homeProductFive);

        //Redirecting the click event to amazon product
        binding.homeBtnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amazonProductUrl = "https://www.amazon.com.au/Friendly-No-Rinse-Waterless-Shampoo-Coconut/dp/B00GZQYLOE/ref=sr_1_27?crid=3NDK7F3HG1SL9&dib=eyJ2IjoiMSJ9.vQJMA9-z5wSEext0PF2vbYJzmz9KEFlaJRGAZ1I2KY51MF31aniRwqWo3R1EV0BoNkK4EHnxNvzxrrS8RqCIxAZg_JLax_lyMR_2zCsM5WqR161-zs5PlcIINWvoCPXp4vozsinsUk4A4UA2j7vRVna1PHHu41j7EllA4F90CByPdmSF6Q5hK_v1TQxFittikT9qSLpGSOTGWzyToJ_xrrAdKHtV03WEGSflXtMeBgDLZoU2lm9Edcn5Opui-ytZYOCNViy6nshO3NrFJqmn2HF0B_NtnbJgjljlAmMrdpg.h-gLSYFCaJujnHEXUnohd5uED8z9P-nv3HS5J-mMxGE&dib_tag=se&keywords=dog%2Bproducts&qid=1713047201&sprefix=dog%2Bproducts%2Caps%2C299&sr=8-27&th=1";
                Uri uri = Uri.parse(amazonProductUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //Product six
        Picasso.get().load("https://m.media-amazon.com/images/I/71zl59tnvyL._AC_SY300_SX300_.jpg")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(binding.homeProductSix);

        //Redirecting the click event to amazon product
        binding.homeBtnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amazonProductUrl = "https://www.amazon.com.au/FLEXECHO-Professional-Detachable-Rechargeable-Pet%EF%BC%86Quiet/dp/B09MCWYPPW/ref=sr_1_29?crid=3NDK7F3HG1SL9&dib=eyJ2IjoiMSJ9.vQJMA9-z5wSEext0PF2vbYJzmz9KEFlaJRGAZ1I2KY51MF31aniRwqWo3R1EV0BoNkK4EHnxNvzxrrS8RqCIxAZg_JLax_lyMR_2zCsM5WqR161-zs5PlcIINWvoCPXp4vozsinsUk4A4UA2j7vRVna1PHHu41j7EllA4F90CByPdmSF6Q5hK_v1TQxFittikT9qSLpGSOTGWzyToJ_xrrAdKHtV03WEGSflXtMeBgDLZoU2lm9Edcn5Opui-ytZYOCNViy6nshO3NrFJqmn2HF0B_NtnbJgjljlAmMrdpg.h-gLSYFCaJujnHEXUnohd5uED8z9P-nv3HS5J-mMxGE&dib_tag=se&keywords=dog%2Bproducts&qid=1713047201&sprefix=dog%2Bproducts%2Caps%2C299&sr=8-29&th=1";
                Uri uri = Uri.parse(amazonProductUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


        binding.homeToTheTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.homeFragment.smoothScrollTo(0, 0);
            }
        });

    }
}
