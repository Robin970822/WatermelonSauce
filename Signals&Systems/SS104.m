%%
b1p = 1;
a1p = [8 8 4 1];
w = [-10:0.25:10];
H1p = freqs(b1p, a1p, w);
figure;
plot(w,abs(H1p));xlabel('w');ylabel('|H1p(jw)|');
grid;
zs = roots(b1p)
ps = roots(a1p)
figure;
plot(real(zs),imag(zs),'o');
hold on;
plot(real(ps),imag(ps),'x');
grid;
%%
clc;
clear;
bb1p = 1;
ab1p = [-64 244 -264 105];
[Hb1p w] = freqz(bb1p, ab1p, 1024,'whole');
figure;
plot(w,abs(Hb1p));xlabel('w');ylabel('|Hb1p(jw)|');
title('后向欧拉近似');
grid;

bf1p = 1;
af1p = [64 -160 136 -39];
[Hf1p w] = freqz(bf1p, af1p, 1024,'whole');
figure;
plot(w,abs(Hf1p));xlabel('w');ylabel('|Hf1p(jw)|');
title('前向欧拉近似');
grid;
%%
figure;
dpzplot(bb1p,ab1p);
title('后向欧拉近似');

figure;
dpzplot(bf1p,af1p);
title('前向欧拉近似');