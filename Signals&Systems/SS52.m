%%
clear;
n = [0:999];
d0 = sin(0.7217 * n) + sin(1.0247 * n);
d1 = sin(0.5346 * n) + sin(0.9273 * n);
d2 = sin(0.5346 * n) + sin(1.0247 * n);
d3 = sin(0.5346 * n) + sin(1.1328 * n);
d4 = sin(0.5906 * n) + sin(0.9273 * n);
d5 = sin(0.5906 * n) + sin(1.0247 * n);
d6 = sin(0.5906 * n) + sin(1.1328 * n);
d7 = sin(0.6535 * n) + sin(0.9273 * n);
d8 = sin(0.6535 * n) + sin(1.0247 * n);
d9 = sin(0.6535 * n) + sin(1.1328 * n);
%%
D2 = fft(d2, 2048);
D9 = fft(d9, 2048);
k = [0 : 2047];
omega = 2*pi*k/2048;

figure;
subplot(2,1,1);
plot(omega,abs(D2));xlabel('w');ylabel('|D2|');axis([0.5 1.25 -inf inf]);
subplot(2,1,2);
plot(omega,abs(D9));xlabel('w');ylabel('|D9|');axis([0.5 1.25 -inf inf]);
%%
space = zeros(1,100);
phone = [d1 space d8 space d8 space d2 space d1 space d7 space d8 space d8 space d1 space d0 space d2];
sound(phone, 8192);