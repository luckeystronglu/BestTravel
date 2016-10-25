package com.qf.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.qf.besttravel.LookPicsActivity;
import com.qf.besttravel.R;
import com.qf.besttravel.WorldNoteActivity;
import com.qf.entity.TravelNoteEntity;
import com.qf.widget.GlideCircleTransform;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/9/30.
 */
public class TravelNoteAdapter2 extends RecyclerView.Adapter<TravelNoteAdapter2.NoteHolder> {

    private Context context;
    private List<TravelNoteEntity> datas;

    public final SparseBooleanArray mCollapsedStatus;
    private Intent intent;
    private Intent textintent;

    public TravelNoteAdapter2(Context context) {
        this.context = context;
        this.datas = new ArrayList<>();
        this.mCollapsedStatus = new SparseBooleanArray();
    }

    public void setDatas(List<TravelNoteEntity> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    public void addDatas(List<TravelNoteEntity> data) {
        this.datas.addAll(data);
        this.notifyDataSetChanged();
    }

    @Override
    public NoteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_travelnote, parent, false);
        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(final NoteHolder holder, final int position) {
        //设置数据
        holder.tv_user_name.setText(datas.get(position).getActivity().getUser().getName());
        holder.tv_comment_name.setText(datas.get(position).getUser().getName());
        holder.tv_note_title.setText(datas.get(position).getActivity().getTopic());

        holder.expandableTextView.setText(datas.get(position).getActivity().getDescription(), mCollapsedStatus, position);
        holder.expandableTextView.setOnExpandStateChangeListener(new ExpandableTextView.OnExpandStateChangeListener() {
            @Override
            public void onExpandStateChanged(final TextView textView, boolean isExpanded) {
                if (isExpanded) {

//                    holder.frame_morebtn.setText("点击收缩文章");
//                    holder.frame_morebtn.setTextColor(Color.BLUE);
                    holder.frame_morebtn.setVisibility(View.GONE);

                    if (datas.get(position).getActivity().getParent_district_count() > 1) {
                        holder.world_note_ll.setVisibility(View.VISIBLE);

                        textintent = new Intent(context, WorldNoteActivity.class);
                        textintent.putExtra("user_id", datas.get(position).getActivity().getUser().getId() + "");
                        textintent.putExtra("area_id", datas.get(position).getActivity().getDistricts().get(0).getId());
                        textintent.putExtra("areaname",datas.get(position).getActivity().getDistricts().get(0).getName());
                        textintent.putExtra("worldnote_user_img", datas.get(position).getActivity().getUser().getPhoto_url());
                        textintent.putExtra("worldnote_user_tv", datas.get(position).getActivity().getUser().getName());

                        holder.world_note_ll.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                context.startActivity(textintent);

                            }
                        });
                    } else if (datas.get(position).getActivity().getParent_district_count() == 1) {
//                        holder.frame_morebtn.setPadding(20,20,20,0);
//                        holder.frame_morebtn.setText("点击收缩文章");
                        holder.frame_morebtn.setVisibility(View.GONE);

                    }


                } else {
                    if (datas.get(position).getActivity().getParent_district_count() > 1) {
                        //                    holder.morebtn.setText("点击展开全文");
                        holder.frame_morebtn.setVisibility(View.VISIBLE);
//                    holder.frame_morebtn.setText("点击展开全文");
                        holder.world_note_ll.setVisibility(View.GONE);
                    } else if (datas.get(position).getActivity().getParent_district_count() == 1) {
                        holder.frame_morebtn.setPadding(20, 20, 20, 0);
                        holder.frame_morebtn.setVisibility(View.VISIBLE);
                        holder.frame_morebtn.setText("点击展开全文");
                    }


                }
            }
        });


//        holder.tv_note_summary.setText(datas.get(position).getActivity().getDescription());
//        holder.morebtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                boolean collapsed = holder.tv_note_summary.isCollapsed;
//                if (collapsed) {//如果折叠了,就展开
//                    holder.tv_note_summary.collapse();
//                    holder.morebtn.setText("收起文章");
//                } else {//如果没折叠,就折叠
//                    holder.tv_note_summary.collapse();
//                    holder.morebtn.setText("查看全文");
//                }
//            }
//        });
        holder.tv_likesnum.setText(datas.get(position).getActivity().getLikes_count() + "");
        holder.tv_commentnum.setText(datas.get(position).getActivity().getComments_count() + "");
        holder.tv_favoritenum.setText(datas.get(position).getActivity().getFavorites_count() + "");

        //添加标签
        holder.ll_marks.removeAllViews();//移除线性布局中的所有控件
        List<TravelNoteEntity.ActivityBean.DistrictsBean> markslist = datas.get(position).getActivity().getDistricts();
        if (markslist.size() != 0) {
            for (int i = 0; i < markslist.size(); i++) {
                LinearLayout.LayoutParams llmarkparams = new LinearLayout
                        .LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                llmarkparams.setMargins(10, 10, 2, 10);
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

        if (datas.get(position).getActivity().getPoi() != null && !datas.get(position).getActivity().getPoi().equals("null")) {
            if (datas.get(position).getActivity().getPoi() != null) {
                LinearLayout.LayoutParams llmarkparams2 = new LinearLayout
                        .LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                llmarkparams2.setMargins(10, 10, 2, 10);
                TextView tv = new TextView(context);
                tv.setText(datas.get(position).getActivity().getPoi().getName());
                tv.setBackgroundColor(Color.parseColor("#dedada"));
                tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                tv.setTextColor(Color.GRAY);
                tv.setPadding(12, 4, 12, 4);
                tv.setBackgroundResource(R.drawable.tv_note_marks_shape);
                holder.ll_marks.addView(tv, llmarkparams2);
            }

        }


        List<TravelNoteEntity.ActivityBean.CategoriesBean> catelist = datas.get(position).getActivity().getCategories();
        if (catelist.size() != 0) {
            for (int i = 0; i < catelist.size(); i++) {
                LinearLayout.LayoutParams llmarkparams3 = new LinearLayout
                        .LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                llmarkparams3.setMargins(10, 10, 2, 10);
                TextView tv = new TextView(context);
                tv.setText(catelist.get(i).getName());
                tv.setBackgroundColor(Color.parseColor("#dedada"));
                tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                tv.setTextColor(Color.GRAY);
                tv.setPadding(12, 4, 12, 4);
                tv.setBackgroundResource(R.drawable.tv_note_marks_shape);
                holder.ll_marks.addView(tv, llmarkparams3);
            }
        }

        if (datas.get(position).getActivity().getMade_at() != null) {
            String made_at = datas.get(position).getActivity().getMade_at();
            String[] strings = made_at.split("-");
            String month = strings[1];
            LinearLayout.LayoutParams llmarkparams4 = new LinearLayout
                    .LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            llmarkparams4.setMargins(10, 10, 2, 10);
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
            holder.ll_marks.addView(tv, llmarkparams4);
        }

        //Glide下载列表中大视图图片
        Glide.with(context)
                .load(datas.get(position).getActivity().getContents().get(0).getPhoto_url())
                .crossFade(500)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.avtar_placeholder_big)
                .thumbnail(0.1f)
                .into(holder.bigimg);

        List<TravelNoteEntity.ActivityBean.ContentsBean> imgs = datas.get(position).getActivity().getContents();
        intent = new Intent(context,LookPicsActivity.class);

        holder.bigimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("picnum",0);
                intent.putExtra("entity",datas.get(position));
                context.startActivity(intent);
            }
        });


        //添加scrollview图片
        holder.ll_img.removeAllViews();
//        List<TravelNoteEntity.ActivityBean.ContentsBean> imglist = datas.get(position).getActivity().getContents();
        if (imgs.size() != 0) {

            for (int i = 1; i < imgs.size(); i++) {
                LinearLayout.LayoutParams llimgparams = new LinearLayout.LayoutParams(300, 220);
                llimgparams.rightMargin = 4;
                llimgparams.leftMargin = 6;
                ImageView img = new ImageView(context);
                img.setScaleType(ImageView.ScaleType.FIT_XY);

                Glide.with(context)
                        .load(imgs.get(i).getPhoto_url())
                        .crossFade(500)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
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

                        intent.putExtra("picnum", picnum);
                        intent.putExtra("entity", datas.get(position));
                        context.startActivity(intent);
                    }
                });
            }


        }


        //各地游记篇数note_user_name,note_area,note_num;
        if (datas.get(position).getActivity().getParent_district_count() > 1) {
//            holder.world_note_ll.setVisibility(View.VISIBLE);
            holder.note_user_name.setText(datas.get(position).getActivity().getUser().getName());
            holder.note_area.setText(datas.get(position).getActivity().getDistricts().get(0).getName());
            holder.note_num.setText(datas.get(position).getActivity().getParent_district_count() + "");
        } else if (datas.get(position).getActivity().getParent_district_count() == 1) {
            holder.world_note_ll.setVisibility(View.GONE);
        }


        //Glide下载用户头像
        Glide.with(context)
                .load(datas.get(position).getActivity().getUser().getPhoto_url())
                .crossFade(500)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.home_user_place_holder)
                .transform(new GlideCircleTransform(context))
                .thumbnail(0.1f)
                .into(holder.userimg);

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    public class NoteHolder extends RecyclerView.ViewHolder {
        //        Button morebtn;
//        TextView morebtn;
        TextView frame_morebtn;
        ImageView userimg, bigimg;
        //        CollapsedTextView tv_note_summary;
        TextView tv_user_name, tv_comment_name, tv_note_title;
        TextView tv_likesnum, tv_commentnum, tv_favoritenum;
        LinearLayout ll_img;
        LinearLayout ll_marks;
        LinearLayout world_note_ll;//游记多少篇
        TextView note_user_name, note_area, note_num;

        ExpandableTextView expandableTextView;//可扩展收缩的textview

        public NoteHolder(View itemView) {
            super(itemView);
            this.userimg = (ImageView) itemView.findViewById(R.id.travel_user_img);
            this.bigimg = (ImageView) itemView.findViewById(R.id.travel_big_img);
            this.tv_user_name = (TextView) itemView.findViewById(R.id.travel_user_title);
            this.tv_comment_name = (TextView) itemView.findViewById(R.id.travel_user_whocomment);
            this.tv_note_title = (TextView) itemView.findViewById(R.id.travel_article_title);
//            this.tv_note_summary = (CollapsedTextView) itemView.findViewById(R.id.travel_article_summary);
            this.tv_likesnum = (TextView) itemView.findViewById(R.id.likescount);
            this.tv_commentnum = (TextView) itemView.findViewById(R.id.commentcount);
            this.tv_favoritenum = (TextView) itemView.findViewById(R.id.favCount);
            this.ll_marks = (LinearLayout) itemView.findViewById(R.id.ll_travel_mark);
            this.ll_img = (LinearLayout) itemView.findViewById(R.id.ll_img);
//            this.morebtn = (TextView) itemView.findViewById(R.id.travel_note_morebtn);
            this.expandableTextView = (ExpandableTextView) itemView.findViewById(R.id.expand_text_view);
            this.frame_morebtn = (TextView) itemView.findViewById(R.id.frame_morebtn);

            this.world_note_ll = (LinearLayout) itemView.findViewById(R.id.world_note_ll);
            this.note_user_name = (TextView) itemView.findViewById(R.id.note_user_name);
            this.note_area = (TextView) itemView.findViewById(R.id.note_area);
            this.note_num = (TextView) itemView.findViewById(R.id.note_num);
        }
    }

}
