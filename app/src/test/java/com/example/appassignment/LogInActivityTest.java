package com.example.appassignment;


import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.appassignment.Model.API;
import com.example.appassignment.Model.APIResponse;
import com.example.appassignment.Model.ServiceGenerator;
import com.example.appassignment.View.SignInActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.misusing.NullInsteadOfMockException;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.mockito.PowerMockito;

import retrofit2.Call;
import retrofit2.Callback;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class LogInActivityTest {
    private ServiceGenerator mService;

    @Captor
    private ArgumentCaptor<Callback<APIResponse>> callbackArgumentCaptor;

    @Mock
    private Call<APIResponse> mockCall;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        mService = new ServiceGenerator();
    }

    @Test
    public void testDoAction() throws NullInsteadOfMockException {
        mService.getWeather("a224e30996f54e5abd3130015201711","london");

        mockCall.enqueue(callbackArgumentCaptor.capture());
    }

}
