clear all

n=[-3:7];
x=[0 0 0 2 0 1 -1 3 0 0 0];

stem(n,x);xlabel('n');ylabel('x[n]');

y1=x;
y2=x;
y3=x;
y4=x;

ny1=n+2;
ny2=n-1;
ny3=-n;
ny4=n-1;

figure;
stem(ny1,y1),xlabel('n');ylabel('y1[n]');
figure;
stem(ny2,y2),xlabel('n');ylabel('y2[n]');
figure;
stem(ny3,y3),xlabel('n');ylabel('y3[n]');
figure;
stem(ny4,y4),xlabel('n');ylabel('y4[n]');