function [ X ] = dtftsinc( M, w )
%	X=dtftsinc(M, w)
%   calculates the function X=sin(Mw/2)/sin(w/2)
%   using selective indexing to avoid division by 0
den = sin(w/2);
num = sin(M*w/2);
X = zeros(size(w));
X(den ~= 0) = num(den~=0)./den(den~=0);
X(den==0) = M;
end

