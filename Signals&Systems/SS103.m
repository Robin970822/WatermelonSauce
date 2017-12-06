%%
clear;
clc;
close all;
[b, a] = ellip(4, .2, 40, [.41 .47]);
[H, w] = freqz(b, a, 4096);
figure;
plot(w/pi, 20*log10(abs(H)));
xlabel('w/pi');ylabel('20*log10(abs(H))');
axis([0 1 -80 10]);
grid;
%%
h = filter(b,a,[1 zeros(1, 4095)]);
figure;
stem([0:199],h(1:200));xlabel('n');ylabel('h[n]');
%%
M = max(abs([b a]));
N = 16;
a16 = quant(a, N, M);
b16 = quant(b, N, M);
[H w] = freqz(b16, a16, 4096);
figure;
plot(w/pi, 20*log10(abs(H)));
xlabel('w/pi');ylabel('20*log10(abs(H))');
axis([0 1 -80 10]);
grid;
%%
dpzplot(b16,a16);
%%
M = max(abs([b a]));
N = 12;
a12 = quant(a, N, M);
b12 = quant(b, N, M);
[H w] = freqz(b12, a12, 4096);
figure;
plot(w/pi, 20*log10(abs(H)));
xlabel('w/pi');ylabel('20*log10(abs(H))');
axis([0 1 -80 10]);
grid;
%%
dpzplot(b12,a12);
%%
h = filter(b12,a12,[1 zeros(1, 4095)]);
figure;
stem([0:199],h(1:200));xlabel('n');ylabel('h[n]');