package org.sysoev;


import org.sysoev.task10.ButtonEnableModel;
import org.sysoev.task10.WorkerNameModel;
import org.sysoev.task10.WorkerNameView;
import org.sysoev.task10.WorkerNameViewModel;


public class Main {
    public static void main(String[] args){
        WorkerNameModel nameModel = new WorkerNameModel();
        ButtonEnableModel buttonEnableModel = new ButtonEnableModel();
        WorkerNameViewModel vm = new WorkerNameViewModel(nameModel,buttonEnableModel);

        new WorkerNameView(vm);
    }
}