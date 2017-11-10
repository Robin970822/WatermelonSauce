%%
clear;
a=[1 2*exp(-i*pi/3) exp(i*pi/4) exp(-i*pi/4) 2*exp(i*pi/3)];
x=5*ifft(a);
stem([0:4],x);xlabel('n');ylabel('x[n]');