package com.example.inmobiliaria;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class Propiedades extends Fragment implements Item_Propiedad.OnFragmentInteractionListener  {

    ViewPager viewPager;
    TabLayout tabLayout;
    AppBarLayout appBarLayout;
    ViewPageAdapter vpa;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_propiedades, container, false);


        //ViewGroup contenedor =(ViewGroup)container.getParent();
        //appBarLayout =((ViewGroup)contenedor.getParent()).findViewById(R.id.appBar);
        tabLayout=rootview.findViewById(R.id.tab_propiedad);
        //appBarLayout.addView(tabLayout);

        viewPager= (ViewPager)rootview.findViewById(R.id.viewPager);


         vpa =new  ViewPageAdapter(getChildFragmentManager());;

        //se cargaria dinamicamente con datos de la base ;
        vpa.addFragment(Item_Propiedad.newInstance("San Martin 827","2 dormitorio,cocina,baño","Casa","Alquiler","$5000"),"San Martin");
        vpa.addFragment(Item_Propiedad.newInstance("Mulleady 163 depto 30","salon con dos baños, dos divisiones ","Salon","Comercial","$15000"),"Mulleady");

        viewPager.setAdapter(vpa);
        tabLayout.setupWithViewPager(viewPager);
        ((Principal) getActivity()).getSupportActionBar().setTitle("Propiedades");



        return rootview;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    public class ViewPageAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragmentList = new ArrayList<>();
        private List<String> titulosFragment = new ArrayList<>();

        public ViewPageAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }


        public CharSequence getPageTitle(int posicion) {
            return titulosFragment.get(posicion);
        }

        public void addFragment(Fragment fragment, String titulo) {
            fragmentList.add(fragment);
            titulosFragment.add(titulo);
        }
    }



}
