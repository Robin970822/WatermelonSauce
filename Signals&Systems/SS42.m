%%
clear;
tau = 0.01;
T = 10;
t = [0:tau:T-tau];
y = exp(2*abs(t-5));
N = T/tau;

Y = tau * fft(y);
%%
Y = fftshift(tau*fft(y));
%%
w = -(pi/tau) + (0:N-1)*(2*pi/(N*tau));
%%
X = Y.*exp(j*5*w);
%%
figure;
subplot(2,1,1);
semilogy(w,abs(X));xlabel('w');ylabel('|X(jw)|');
subplot(2,1,2);
semilogy(w,angle(X));xlabel('w');ylabel('angle(X(jw))');

X2 = 4./(4+w.*w);
figure;
subplot(2,1,1);
semilogy(w,abs(X2));xlabel('w');ylabel('|X(jw)|');
subplot(2,1,2);
semilogy(w,angle(X2));xlabel('w');ylabel('angle(X(jw))');
%%
figure;
subplot(2,1,1);
semilogy(w,abs(Y));xlabel('w');ylabel('|Y(jw)|');
subplot(2,1,2);
semilogy(w,angle(Y));xlabel('w');ylabel('angle(Y(jw))');