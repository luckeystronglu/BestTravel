package com.qf.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.qf.besttravel.LookPicsActivity2;
import com.qf.besttravel.R;
import com.qf.entity.WorldNoteEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/9/30.
 */
public class WorldNoteAdapter extends RecyclerView.Adapter<WorldNoteAdapter.NoteHolder> {
    private Context context;
    private List<WorldNoteEntity> datas;
    private Intent intent;


    public WorldNoteAdapter(Context context) {
        this.context = context;
        this.datas = new ArrayList<>();
    }

    public void setDatas(List<WorldNoteEntity> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();
    }



    @Override
    public NoteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_activity_worldnote, parent, false);
        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(final NoteHolder holder, final int position) {
        //设置数据

        if (datas.get(position).getMade_at() != null) {
            String made_at = datas.get(position).getMade_at();
//            String[] strings = made_at.split("T");
//            String date = strings[0]; //方法一
            String date = made_at.substring(0,10);//方法二，截取字符串，【包括0,不包括10)
            if (datas.get(position).getDistricts().get(0).getName() != null){
                String area = datas.get(position).getDistricts().get(0).getName();
                holder.date.setText(date + " "+ area);
            }else {
                holder.date.setText(date);
            }

        }


        holder.tv_note_title.setText(datas.get(position).getTopic());
        holder.tv_note_summary.setText(datas.get(position).getDescription());

        holder.tv_likesnum.setText(datas.get(position).getLikes_count() + "");
        holder.tv_commentnum.setText(datas.get(position).getComments_count() + "");
        holder.tv_favoritenum.setText(datas.get(position).getFavorites_count() + "");

        //添加标签
        holder.ll_marks.removeAllViews();//移除线性布局中的所有控件
        List<WorldNoteEntity.DistrictsBean> markslist = datas.get(position).getDistricts();
        if (markslist.size() != 0) {
            for (int i = 0; i < markslist.size(); i++) {
                LinearLayout.LayoutParams llmarkparams = new LinearLayout
                        .LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                llmarkparams.rightMargin = 12;
                llmarkparams.topMargin = 10;
                llmarkparams.bottomMargin = 10;
                TextView tv = new TextView(context);
                tv.setText(markslist.get(i).getName());
                tv.setBackgroundColor(Color.parseColor("#dedada"));
                tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                tv.setTextColor(Color.GRAY);
                tv.setPadding(12, 4, 12, 4);
                tv.setBackgroundResource(R.drawable.tv_note_marks_shape);

                holder.ll_marks.addView(tv, llmarkparams);
            }
        }

        if (datas.get(position).getPoi() != null && !datas.get(position).getPoi().equals("null")) {
            if (datas.get(position).getPoi().getName() != null){
                LinearLayout.LayoutParams llmarkparams2 = new LinearLayout
                        .LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                llmarkparams2.rightMargin = 12;
                llmarkparams2.topMargin = 10;
                llmarkparams2.bottomMargin = 10;
                TextView tv = new TextView(context);
                tv.setText(datas.get(position).getPoi().getName());
                tv.setBackgroundColor(Color.parseColor("#dedada"));
                tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                tv.setTextColor(Color.GRAY);
                tv.setPadding(12, 4, 12, 4);
                tv.setBackgroundResource(R.drawable.tv_note_marks_shape);
                holder.ll_marks.addView(tv,llmarkparams2);
            }

        }

        List<WorldNoteEntity.CategoriesBean> catelist = datas.get(position).getCategories();
        if (catelist.size() != 0) {
            for (int i = 0; i < catelist.size(); i++) {
                LinearLayout.LayoutParams llmarkparams3 = new LinearLayout
                        .LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                llmarkparams3.rightMargin = 12;
                llmarkparams3.topMargin = 10;
                llmarkparams3.bottomMargin = 10;
                TextView tv = new TextView(context);
                tv.setText(catelist.get(i).getName());
                tv.setBackgroundColor(Color.parseColor("#dedada"));
                tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                tv.setTextColor(Color.GRAY);
                tv.setPadding(12, 4, 12, 4);
                tv.setBackgroundResource(R.drawable.tv_note_marks_shape);
//                tv.getLayoutParams();
                holder.ll_marks.addView(tv, llmarkparams3);
            }
        }

        if (datas.get(position).getMade_at() != null){
            String made_at = datas.get(position).getMade_at();
            String[] strings = made_at.split("-");
            String month = strings[1];
            LinearLayout.LayoutParams llmarkparams4 = new LinearLayout
                    .LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            llmarkparams4.rightMargin = 12;
            llmarkparams4.topMargin = 10;
            llmarkparams4.bottomMargin = 10;
            TextView tv = new TextView(context);
            tv.setBackgroundColor(Color.parseColor("#dedada"));
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
            tv.setTextColor(Color.GRAY);
            tv.setPadding(12, 4, 12, 4);
            switch (month) {
                case "01":
                    tv.setText("一月");

                    break;
                case "02":
                    tv.setText("二月");

                    break;
                case "03":
                    tv.setText("三月");

                    break;
                case "04":
                    tv.setText("四月");

                    break;
                case "05":
                    tv.setText("五月");

                    break;
                case "06":
                    tv.setText("六月");

                    break;
                case "07":
                    tv.setText("七月");

                    break;
                case "08":
                    tv.setText("八月");

                    break;
                case "09":
                    tv.setText("九月");

                    break;
                case "10":
                    tv.setText("十月");

                    break;
                case "11":
                    tv.setText("十一月");

                    break;
                case "12":
                    tv.setText("十二月");

                    break;
                default:
                    tv.setText("");

                    break;

            }
            tv.setBackgroundResource(R.drawable.tv_note_marks_shape);
            holder.ll_marks.addView(tv,llmarkparams4);
        }



        List<WorldNoteEntity.ContentsBean> imglist = datas.get(position).getContents();
        intent = new Intent(context,LookPicsActivity2.class);

        //Glide下载列表中大视图图片
        Glide.with(context)
                .load(datas.get(position).getContents().get(0).getPhoto_url())
                .crossFade(500)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.avtar_placeholder_big)
                .thumbnail(0.1f)
                .into(holder.bigimg);

        holder.bigimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("picnum2",0);
                intent.putExtra("entity2", datas.get(position));
                context.startActivity(intent);
            }
        });


        //添加scrollview图片
        holder.ll_img.removeAllViews();

        if (imglist.size() != 0) {
            for (int i = 1; i < imglist.size(); i++) {
                LinearLayout.LayoutParams llimgparams = new LinearLayout.LayoutParams(300, 220);
                llimgparams.rightMargin = 4;
                llimgparams.leftMargin = 6;
                ImageView img = new ImageView(context);
                img.setScaleType(ImageView.ScaleType.FIT_XY);

                Glide.with(context)
                        .load(datas.get(position).getContents().get(i).getPhoto_url())
                        .crossFade(500)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.avtar_placeholder_small)
                        .thumbnail(0.1f)
                        .into(img);
                img.setPadding(0, 10, 0, 0);
                img.setTag(i);
                img.setClickable(true);

                holder.ll_img.addView(img, llimgparams);

                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int picnum = (int) v.getTag();

                        intent.putExtra("picnum2", picnum);
                        intent.putExtra("entity2", datas.get(position));
                        context.startActivity(intent);
                    }
                });
            }
        }



        //Glide下载用户头像
//        Glide.with(context)
//                .load(datas.get(position).getActivity().getUser().getPhoto_url())
//                .crossFade(500)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .placeholder(R.drawable.home_user_place_holder)
//                .transform(new GlideCircleTransform(context))
//                .thumbnail(0.1f)
//                .into(holder.userimg);



    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    public class NoteHolder extends RecyclerView.ViewHolder {

        TextView date;
        ImageView bigimg;
        TextView tv_note_summary,tv_note_title;
        TextView tv_likesnum, tv_commentnum, tv_favoritenum;
        LinearLayout ll_img;
        LinearLayout ll_marks;



        public NoteHolder(View itemView) {
            super(itemView);
            this.date = (TextView) itemView.findViewById(R.id.date_tv_noteitem);
            this.bigimg = (ImageView) itemView.findViewById(R.id.travel_big_img);
//            this.tv_comment_name = (TextView) itemView.findViewById(R.id.travel_user_whocomment);
            this.tv_note_title = (TextView) itemView.findViewById(R.id.travel_article_title);
            this.tv_note_summary = (TextView) itemView.findViewById(R.id.travel_article_summary);
            this.tv_likesnum = (TextView) itemView.findViewById(R.id.likescount);
            this.tv_commentnum = (TextView) itemView.findViewById(R.id.commentcount);
            this.tv_favoritenum = (TextView) itemView.findViewById(R.id.favCount);
            this.ll_marks = (LinearLayout) itemView.findViewById(R.id.ll_travel_mark);
            this.ll_img = (LinearLayout) itemView.findViewById(R.id.ll_img);

        }
    }

}
