package bhavin.nybooks.ui.base;


import android.view.View;

public class BasePresenter<ViewT> implements IBasePresenter<ViewT> {

    protected ViewT view;

    @Override
    public void onViewActive(ViewT view) {
        this.view=view;
    }

    @Override
    public void onViewInactive() {
        this.view=null;
    }
}
