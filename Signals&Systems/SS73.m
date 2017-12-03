%%
clear;
n = [0:124];
x1 = (sinc(0.4*(n-62))).^2;
x2 = (sinc(0.2*(n-62))).^2;
figure;
subplot(2,1,1);
stem(n,x1);xlabel('n');ylabel('x1');
subplot(2,1,2);
stem(n,x2);xlabel('n');ylabel('x2');
%%
N=2048;
k=0:2047;
wk=2*pi*k/2048;
x1=sinc(0.4*(k-62)).*sinc(0.4*(k-62));
x2=sinc(0.2*(k-62)).*sinc(0.2*(k-62));
X1=fft(x1,N);
X2=fft(x2,N);
 
subplot(2,1,1);
plot(wk,abs(X1));
grid on;
title('|X1|');
subplot(2,1,2);
plot(wk,abs(X2));
grid on;
title('|X2|');
%%
clc;
clear;
N=2048;
n=0:2047;
x1=sinc(0.4*(n-62)).*sinc(0.4*(n-62));
x2=sinc(0.2*(n-62)).*sinc(0.2*(n-62));
xe1=zeros(1,3*length(x1));
xe1(1:3:length(xe1))=x1;
xe2=zeros(1,3*length(x2));
xe2(1:3:length(xe1))=x2;
Xe1=fft(xe1,N);
Xe2=fft(xe2,N)
subplot(2,1,1);
plot(n,Xe1);
title('Xe1');
grid on;
subplot(2,1,2);
plot(n,Xe2);
title('Xe2')
grid on;