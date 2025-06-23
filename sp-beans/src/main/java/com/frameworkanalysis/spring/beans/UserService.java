package com.frameworkanalysis.spring.beans;

class UserService {
    private  ItemService itemService;

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }
    public void sayHello(){
        System.out.println("Hello Spring beans, itemService is["+itemService.toString()+"]");
    }
}
