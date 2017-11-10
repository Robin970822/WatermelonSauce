clear all

n=[-1 0 1];
x1=[0 1 0];
x2=[0 2 0];

y1=sin(pi/2)*x1;
y2=sin(pi/2)*x2;

figure;
subplot(2,2,1);
stem(n,x1);xlabel('n');ylabel('x1[n]');
subplot(2,2,2);
stem(n,x2);xlabel('n');ylabel('x2[n]');
subplot(2,2,3);
stem(n,y1);xlabel('n');ylabel('y1[n]');
subplot(2,2,4);
stem(n,y2);xlabel('n');ylabel('y2[n]');

clear all;

x=[zeros(10,1)' ones(11,1)'];

for n = 1 : length(x)-1
    y(n) = x(n) + x(n+1);
end

figure;
subplot(2,1,1);
stem([-5:9],x(6:20));xlabel('n');ylabel('x[n]');
subplot(2,1,2);
stem([-6:9],y(4:19));xlabel('n');ylabel('y[n]');
