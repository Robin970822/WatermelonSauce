%%
clear;
close all;
nx=[0:5];
x=[1 5 2 4 -2 2];
nh=[-3:3];
h=1-(abs(nh)/3);
figure;
subplot(2,1,1);
stem(nx,x);xlabel('n');ylabel('x[n]');
subplot(2,1,2);
stem(nh,h);xlabel('n');ylabel('h[n]');
%%
y=conv(x,h);
ny=[-3:8];
figure;
stem(ny,y);xlabel('n');ylabel('y[n]');