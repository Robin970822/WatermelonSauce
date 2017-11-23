%%
clear;
a = [6 -5 1];
b = [1 -1];
%%
num = [-1 1];
den = [1 -5 6];
%%
[r, p, k]=residue(num,den);
%%
n = [0:63];
x = [1 zeros(1,63)];
h = filter(b, a, x);
hh = (2/3)*(1/3).^n - (1/2)*(1/2).^n;
figure;
stem(n,h);
figure;
stem(n,hh);