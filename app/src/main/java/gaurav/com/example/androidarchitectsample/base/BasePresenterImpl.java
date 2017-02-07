package gaurav.com.example.androidarchitectsample.base;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import gaurav.com.example.androidarchitectsample.R;
import gaurav.com.example.androidarchitectsample.data.remote.APIServiceHelper;

/**
 * Created by Gaurav on 10/7/16.
 */

public abstract class BasePresenterImpl implements BasePresenter {
    BaseView mBaseView;
    EventBus mEventBus;

    public BasePresenterImpl(BaseView baseView) {
        mBaseView = baseView;
        mEventBus = EventBus.getDefault();
    }

    @Override
    public void resume() {
        if (!mEventBus.isRegistered(this)) {
            mEventBus.register(this);
        }
    }

    @Override
    public void pause() {
        mEventBus.unregister(this);
    }

    @Override
    public void stop() {
        mEventBus.unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(APIServiceHelper serviceHelper) {
        switch (serviceHelper.getActionType()) {
            case NO_INTERNET:
                mBaseView.showError(mBaseView.getAppContext().getString(R.string.error_no_internet));
                break;
            case START_REQUEST:
                mBaseView.showProgress();
                break;
            case END_REQUEST:
                mBaseView.hideProgress();
                break;
            case ERROR:
                mBaseView.hideProgress();
                mBaseView.showError(serviceHelper.getErrorMessage());
                break;
        }
    }
}
