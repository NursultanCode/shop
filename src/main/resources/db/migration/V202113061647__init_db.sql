INSERT INTO public.products (
cost, count, name, description, category_id) VALUES (
'15'::real, '5'::integer, 'Milk'::character varying, 'Natural cow milk'::character varying,'1'::bigint)
 returning id;