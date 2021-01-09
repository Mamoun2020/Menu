package com.example.menu.menurestaurante;

import androidx.fragment.app.Fragment;

import java.security.PrivateKey;

public class MainTab {
  ItemTab itemTab;
  Fragment fragment_tabLayout;

  public MainTab(ItemTab itemTab, Fragment fragment_tabLayout) {
    this.itemTab = itemTab;
    this.fragment_tabLayout = fragment_tabLayout;
  }

  public ItemTab getItemTab() {
    return itemTab;
  }

  public void setItemTab(ItemTab itemTab) {
    this.itemTab = itemTab;
  }

  public Fragment getFragment_tabLayout() {
    return fragment_tabLayout;
  }

  public void setFragment_tabLayout(Fragment fragment_tabLayout) {
    this.fragment_tabLayout = fragment_tabLayout;
  }
}
