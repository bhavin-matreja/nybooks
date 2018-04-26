package bhavin.nybooks.ui.base;


import android.view.View;

public interface IBasePresenter<ViewT> {

    void onViewActive(ViewT view);

    void onViewInactive();
}
