%%
clear
load splat
y=y(1:8192);
N=8192;
fs=8192;
sound(y,fs)
%%
Y=fftshift(fft(y));
w=[-pi:2*pi/N:pi-pi/N]*fs;
y=ifft(fftshift(Y));
y=real(y);
