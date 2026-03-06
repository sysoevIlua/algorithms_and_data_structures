package org.sysoev.task10;

public class WorkerNameViewModel implements Observer {

    private final WorkerNameModel nameModel;
    private final ButtonEnableModel buttonEnableModel;

    private View view;

    public WorkerNameViewModel(WorkerNameModel nameModel, ButtonEnableModel  enableModel) {
        this.nameModel = nameModel;
        this.buttonEnableModel = enableModel;
        nameModel.addObserver(this);
        enableModel.addObserver(this);
    }

    public void initView(View view) {
        this.view = view;
        update();
    }

    public void changeName(String text) {
        nameModel.changeWorkerName(text);

        if (text != null && !text.isBlank()) {
            buttonEnableModel.setEnable();
        } else {
            buttonEnableModel.setDisable();
        }
    }

    public void clickButton() {
        nameModel.changeWorkerName("");
    }

    @Override
    public void update() {
        if (view != null) {
            view.view(nameModel.getWorkerName(), buttonEnableModel.isEnable());
        }
    }
}
