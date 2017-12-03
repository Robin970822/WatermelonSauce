%%
clear;
n = [0:8191];
T = 1/8192;
t = n*T;
omega0 = 2*pi*1000;
x = sin(omega0*t);
%%
figure;
subplot(2,1,1);
stem(n(1:50),x(1:50));xlabel('n');ylabel('x[n]');
subplot(2,1,2);
plot(n(1:50)*T,x(1:50));xlabel('t');ylabel('x(t)');
%%
[X, w] = ctfts(x,T);
figure;
plot(w,abs(X));xlabel('w');ylabel('|X(jw)|');