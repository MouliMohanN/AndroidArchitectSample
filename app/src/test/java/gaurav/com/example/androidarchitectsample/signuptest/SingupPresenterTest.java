package gaurav.com.example.androidarchitectsample.signuptest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gaurav.com.example.androidarchitectsample.data.remote.RestApiComponent;
import gaurav.com.example.androidarchitectsample.signup.signup.SignupContract;
import gaurav.com.example.androidarchitectsample.signup.signup.SignupPresenter;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Gaurav on 07/02/17.
 */

public class SingupPresenterTest {

    @Mock
    private SignupContract.View mSignUpView;

    @Mock
    private RestApiComponent restApiComponent;

    private SignupPresenter signupPresenter;

    @Before
    public void setupMocksAndView()
    {
        MockitoAnnotations.initMocks(this);
        signupPresenter = new SignupPresenter(restApiComponent,mSignUpView);
        when(mSignUpView.isActive()).thenReturn(true);
    }

    @Test
    public void shouldShowErrorMessageWhenMobileNoIsEmpty() throws Exception {
        when(mSignUpView.getMobileNo()).thenReturn("");
        signupPresenter.signUp(mSignUpView.getMobileNo(),mSignUpView.getPassword());
        verify(mSignUpView).showEmptyMobileError();
    }

    @Test
    public void shouldShowErrorMessageWhenPasswordIsEmpty() throws Exception {
        when(mSignUpView.getMobileNo()).thenReturn("12345");
        when(mSignUpView.getPassword()).thenReturn("");
        signupPresenter.signUp(mSignUpView.getMobileNo(),mSignUpView.getPassword());
        verify(mSignUpView).showEmptyPasswordError();
    }

//    @Test
//    public void shouldShowErrorMessageWhenWrongDetails() throws Exception {
//        when(mSignUpView.getMobileNo()).thenReturn("12345");
//        when(mSignUpView.getPassword()).thenReturn("22");
//        signupPresenter.signUp(mSignUpView.getMobileNo(),mSignUpView.getPassword());
//        verify(signupPresenter).onEvent(null);
//    }

//    @Test
//    public void shouldShowValidMobileNoErrorWhenNotValid() throws Exception
//    {
//        when(mSignUpView.getMobileNo()).thenReturn("1234");
//
//    }
}
