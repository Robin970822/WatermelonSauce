%%
clear;
N = 64;
n = [0: N-1];
x = (-3/4).^n;
y = (2/5)*(1/2).^n + (3/5)*(-3/4).^n;
%%
w = 2*pi*n/N;
X = fft(x);
Y = fft(y);
figure;
plot(w,abs(X));
xlabel('w');ylabel('|X(jw)|');axis([0 2*pi -inf inf]);
figure;
plot(w,abs(Y));
xlabel('w');ylabel('|Y(jw)|');axis([0 2*pi -inf inf]);
%%
H = Y./X;
h = ifft(H);
figure;
stem(n,h);
%%
hh = 2/5*(1/4).^(n-1);
hh(1) = 1;
figure;
stem(n,hh);