%%
clear;
n = [0:10];
x = ones(1,10);
%%
N = 100;
k = [0: N-1];
w = 2*pi*k/N; 
X = exp(-5*i*w).*dtftsinc(11,w);
figure;
subplot(2,1,1);
plot(w,abs(X));xlabel('w');ylabel('|X(jw)|');
subplot(2,1,2);
plot(w,angle(X));xlabel('w');ylabel('angle(X(jw))');
%%
clear X;
w = w - pi;
X = fft(x, N);
X = fftshift(X);
figure;
subplot(2,1,1);
plot(w,abs(X));xlabel('w');ylabel('|X(jw)|');
subplot(2,1,2);
plot(w,angle(X));xlabel('w');ylabel('angle(X(jw))');
%%
Xr = real(exp(i*w*5).*X);
figure;
subplot(2,1,1);
plot(w,Xr);xlabel('w');ylabel('|Xr(jw)|');
subplot(2,1,2);
plot(w,angle(Xr));xlabel('w');ylabel('angle(Xr(jw))');

Xr = dtftsinc(11,w);
figure;
subplot(2,1,1);
plot(w,Xr);xlabel('w');ylabel('|Xr(jw)|');
subplot(2,1,2);
plot(w,angle(Xr));xlabel('w');ylabel('angle(Xr(jw))');
%%
n = [0:6];
z = [5 4 3 2 1 0];
Z = fft(z,N);
Z = fftshift(Z);
figure;
subplot(2,1,1);
plot(w,real(Z));xlabel('w');ylabel('Z(jw)');
subplot(2,1,2);
plot(w,angle(real(Z)));xlabel('w');ylabel('angle(Z(jw))');