%%
n=[0:1000];
impuse=[1 zeros(1,1000)];
a=1;
b=[1 zeros(1,999) 0.5];
he=filter(b,a,impuse);
stem(n,he);xlabel('n');ylabel('h[n]');
%%
z=filter(a,b,he);
stem(n,z);xlabel('n');ylabel('z[n]');