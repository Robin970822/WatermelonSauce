%%
clear;
close all;
nh=[-1:1];
h=[2 0 2];
nx=[0 1 2];
x=[1 0 1];

y=conv(h,x);
ny=[-1:3];
stem(ny,y);xlabel('n');ylabel('y[n]');
%%
nx=[0:24];
nh=[0:14];
for i=1:length(nx)
    x(i)=(1/2)^(nx(i)-2)*SSu(nx(i)-2);
end
h=SSu(nh+2);

y=conv(h,x);
ny=[0:38];
figure;
stem(ny,y);xlabel('n');ylabel('y[n]');
hold on;
stem(ny(16:length(ny)),y(16:length(y)),'r');