%% 
clear
nx1=[0:9];
x1=[1 1 1 1 1 0 0 0 0 0];
h1=[1 -1 3 0 1];
h2=[0 2 5 4 -1];
nh1=[0:4];
figure;
stem(nx1,x1);
figure;
stem(nh1,h1);
figure;
stem(nh1,h2);
%%
close all;
y1=conv(x1,h1);
y2=conv(h1,x1);
subplot(2,1,1);
stem([0:length(y1)-1],y1);xlabel('n');ylabel('x1[n]*h1[n]');
subplot(2,1,2);
stem([0:length(y2)-1],y2);xlabel('n');ylabel('h1[n]*x1[n]');
%%
clear y1 y2
close all;
y1=conv(x1,h1);
y2=conv(x1,h2);
y3=y1+y2;
h3=h1+h2;
y4=conv(x1,h3);
subplot(2,1,1);
stem([0:length(y3)-1],y3);xlabel('n');ylabel('x1[n]*h1[n]+x1[n]*h2[n]');
subplot(2,1,2);
stem([0:length(y4)-1],y4);xlabel('n');ylabel('x1[n]*(h1[n]+h2[n])');
%%
close all;
w=conv(x1,h1);
yd1=conv(w,h2);

hs=conv(h1,h2);
yd2=conv(x1,hs);

subplot(2,1,1);
stem([0:length(yd1)-1],yd1);xlabel('n');ylabel('(x1[n]*h1[n])*h2[n]');
subplot(2,1,2);
stem([0:length(yd2)-1],yd2);xlabel('n');ylabel('x1[n]*(h1[n]*h2[n])');