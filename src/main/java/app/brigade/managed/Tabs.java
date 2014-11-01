/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.brigade.managed;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;

/**
 *
 * @author Илья
 */
@ManagedBean
public class Tabs {

private List<String> tabList = new ArrayList<>();

public Tabs(){
      tabList.add("index.xhtml");
      tabList.add("index.xhtml");
      tabList.add("index.xhtml");
}

public List<String> getTabList() {

    return tabList;
}

public void setTabList(List<String> tabList) {
    this.tabList = tabList;
}
}
